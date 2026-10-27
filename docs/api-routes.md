# SoloFit API Routes

Base URL (local): `http://localhost:8080/SoloFit`

✅ = implemented on `main` · 🔲 = planned, not implemented yet

Every implemented route has a matching request in the Bruno collection (`bruno/`).

## GET methods

### User Entity

* ✅ All users: `GET /user`
* ✅ User by userId: `GET /user/{id}`
* ✅ Users where name contains: `GET /user/search?name={name}`

### Exercise Entity

* ✅ All exercises: `GET /api/exercises`
* ✅ Exercise by exerciseId: `GET /api/exercises/{id}`
* ✅ Exercises where name contains: `GET /api/exercises/search?name={name}`
* ✅ Exercises by primaryMuscle: `GET /api/exercises/primaryMuscle?primaryMuscle={muscle}`
* ✅ Exercises by secondaryMuscle: `GET /api/exercises/secondaryMuscle?secondaryMuscle={muscle}`

### Template Entity

* ✅ All templates: `GET /api/templates`
* ✅ Template by templateId: `GET /api/templates/{id}`
* ✅ Templates where dayOfWeek contains: `GET /api/templates/search?day={day}`

## POST methods

* ✅ New User: `POST /user/add` with body `{"name": "...", "goal": "..."}`
* ✅ New Template: `POST /api/templates` with body `{"dayOfWeek": "...", "userId": 1, "exerciseIds": [1, 2]}`
* 🔲 New Exercise

## PUT methods

* ✅ Change a user's goal: `PUT /user/{id}/changeGoal` with body `{"newGoal": "..."}`
* ✅ Update Template: `PUT /api/templates/{id}` with the same body as New Template
* 🔲 Update Exercise

## DELETE methods

* ✅ Delete Template: `DELETE /api/templates/{id}` (returns 204; removes its `template_exercises` rows, keeps the exercises)
* 🔲 Delete User
* 🔲 Delete Exercise

## Responses and errors

| Situation | Status |
|---|---|
| GET or PUT succeeded | `200 OK` |
| POST created something | `201 Created` |
| DELETE succeeded | `204 No Content` |
| Body fails validation, or references a user/exercise that doesn't exist | `400 Bad Request` |
| No entity with that id | `404 Not Found` |

Errors come back as JSON (`status`, `detail`, and for validation errors an `errors` map of field → message).

## Things to consider

* **Are we returning every property the entity has?**
  * **User:** the DTO returns every column except `triceps`, which exists on the entity but not yet on `UserDto`.
  * **Exercise:** the DTO returns every column.
  * **Template:** the DTO returns `templateId`, `dayOfWeek`, `userId`, and a short list of exercises (`exerciseId` and `name` only) instead of full User/Exercise objects. That keeps responses small and avoids the Template ↔ Exercise loop.
* **Template writes use a request DTO** (`TemplateRequest`): clients send `exerciseIds`, and the service looks up the exercises and fills in the `template_exercises` join table.
* **Route prefixes are inconsistent:** users live at `/user`, exercises and templates at `/api/...`. Moving users to `/api/users` would make the API uniform, but the front end must be updated at the same time.
