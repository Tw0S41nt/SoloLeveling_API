# SoloFit API Routes

## GET methods

### User Entity

* All users
* User by userId
* User where name contains

### Exercise Entity

* All exercises
* Exercise by exerciseId
* Exercise where name contains
* Exercises by primaryMuscle
* Exercises by secondaryMuscle

### Template Entity

* All templates
* Template by templateId
* Templates where dayOfWeek contains

## POST methods

* New Template

## PUT methods

* Update Template

## DELETE methods

* Delete Template

## Things to consider

* **Are we returning every property the entity has?**
  * **User:** the DTO returns every column except `triceps`, which is also missing from the `User` entity. It needs to be added to both.
  * **Exercise:** the DTO returns every column.
  * **Template:** the DTO returns `templateId`, `dayOfWeek`, `userId`, and a short list of exercises (`exerciseId` and `name` only), not the full User or Exercise objects.
