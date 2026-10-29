# SoloFit API

Spring Boot REST API for **SoloFit**, a beginner-friendly workout template app. It serves users, exercises, and workout templates (a day of the week plus a list of exercises) from a MariaDB database.

## Required tools

| Tool | Version | Used for |
|---|---|---|
| Java (JDK) | 17 | Building and running the service |
| Docker Desktop | Any recent | Running the MariaDB database container |
| Bruno | 2.x or newer | Testing the endpoints |
| Git | Any | Cloning this repo and the database repo |

Gradle doesn't need to be installed: the included wrapper (`./gradlew`) downloads the right version (9.7.1) the first time you run it. The other main dependencies (Spring Boot 3.5, Spring Data JPA, the MariaDB driver, Lombok, MapStruct, and Spotless) are declared in `build.gradle`.

## 1. Start the database

The database lives in a separate repo: **[Tw0S41nt/SoloLeveling_Database](https://github.com/Tw0S41nt/SoloLeveling_Database)**.

```bash
git clone https://github.com/Tw0S41nt/SoloLeveling_Database.git
cd "SoloLeveling_Database/DATABASE/Table initialization"
docker compose up -d
```

This starts a MariaDB container named `SoloFit` on **port 999**, with database `SoloFit_Database` and user `user` / password `password`. The service is already configured for these in `src/main/resources/application.properties`.

**Starting it again later:** `docker start SoloFit`. Don't run `docker compose down` unless you want to wipe the data.

**Check that the seed data loaded:**

```bash
docker exec SoloFit mariadb -uuser -ppassword SoloFit_Database -e "SELECT * FROM templates;"
```

You should see 4 templates. If the tables are empty, the seed section of `script.sql` didn't run. Its `--- Seed Data` line isn't a valid MariaDB comment (it needs to be `-- Seed Data`). Either fix that line and recreate the container with `docker compose down` then `docker compose up -d`, or paste the `INSERT` statements from `script.sql` into:

```bash
docker exec -i SoloFit mariadb -uuser -ppassword SoloFit_Database
```

## 2. Run the API

Use the `main` branch.

```bash
git clone https://github.com/Tw0S41nt/SoloLeveling_API.git
cd SoloLeveling_API
git checkout main
./gradlew bootRun
```

On Windows Command Prompt, use `gradlew bootRun`.

The service is ready when the log shows `Started SoloFitApplication`. It listens at:

```
http://localhost:8080/SoloFit
```

Quick check in a browser: <http://localhost:8080/SoloFit/api/templates/1> should return Monday's template with Bench Press and Overhead Press.

Stop it with **Ctrl+C**.

## 3. Test with Bruno

Every route is listed in **[docs/api-routes.md](docs/api-routes.md)**, which also marks what's implemented.

1. In Bruno: **Open Collection**, then choose the `bruno/` folder in this repo.
2. Select the **Local** environment in the top-right dropdown.
3. Run the requests, or right-click the collection and choose **Run** to run all of them. Every request has a status-code assertion, so the runner shows pass/fail.

### Guided demo

Run these in order. Each one builds on the one before.

| # | Request | Expect |
|---|---|---|
| 1 | Templates → **Get All Templates** | `200`: 4 seeded templates (Mon, Wed, Tue, Fri) with their exercises |
| 2 | Templates → **Get Template By Id** (`/1`) | `200`: Monday, user 1, Bench Press and Overhead Press |
| 3 | Templates → **Search Templates By Day** (`?day=monday`) | `200`: just the Monday template |
| 4 | Templates → **Create Template** | `201`: a new Thursday template with Squat and Bicep Curl; its id is saved for the next steps |
| 5 | Templates → **Update Template** | `200`: that template is now Saturday, user 3, Bench Press and Squat |
| 6 | Templates → **Delete Template** | `204`: the new template is gone, so a repeat of step 1 shows 4 again |
| 7 | Exercises → **Get Exercises By Primary Muscle** (`Chest`) | `200`: Bench Press |
| 8 | Users → **Create User**, then **Change User Goal** | `201` then `200`: a new user whose goal changes to Hypertrophy |

Steps 4–6 clean up after themselves, so the demo can be repeated. **Update Template** and **Delete Template** use the id saved by **Create Template**, so run Create first. Each run of **Create User** adds a new user.

Example error responses:
- `GET /api/templates/999` returns `404 Not Found`.
- `POST /api/templates` with `"userId": 999` returns `400 Bad Request`.

## Project layout

Package-by-layer, under `src/main/java/com/sololeveling/solofit`:

| Package | Contents |
|---|---|
| `controller` | REST endpoints |
| `service` | Business logic |
| `repository` | Spring Data JPA repositories |
| `model` | JPA entities: `User`, `Exercise`, `Template` |
| `dto` | Request/response objects |
| `mapper` | Entity → DTO conversion |
| `exception` | Global error handling (404/400 JSON responses) |

Before committing, format the code with:

```bash
./gradlew spotlessApply
```
