package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models._

@Singleton
class UserController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  var users = scala.collection.mutable.ArrayBuffer(
    User(1, "Divyansh", "divyansh@example.com"),
    User(2, "kuki", "kukih@example.com")
  )

  def getUsers = Action {
    Ok(Json.toJson(users))
  }

  def getUser(id: Long) = Action {
    users.find(_.id == id) match {
      case Some(user) => Ok(Json.toJson(user))
      case None => NotFound
    }
  }

  def createUser = Action(parse.json[User]) { request =>
    val newUser = request.body
    users += newUser
    Created(Json.toJson(newUser))
  }

  def updateUser(id: Long) = Action(parse.json[User]) { request =>
    users.find(_.id == id) match {
      case Some(_) =>
        val updatedUser = request.body.copy(id = id)
        users = users.filterNot(_.id == id) += updatedUser
        Ok(Json.toJson(updatedUser))
      case None => NotFound
    }
  }

  def deleteUser(id: Long) = Action {
    users.find(_.id == id) match {
      case Some(_) =>
        users = users.filterNot(_.id == id)
        NoContent
      case None => NotFound
    }
  }
}
