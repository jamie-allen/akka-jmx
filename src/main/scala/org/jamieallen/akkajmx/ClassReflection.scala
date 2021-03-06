package org.jamieallen.akkajmx

import scala.reflect.runtime.{ universe => ru }
import akka.actor.Actor

class CustomerActor extends Actor {
  val name = "Jamie"
  var address = "somewhere"

  def receive = {
    case _ => println("wat?")
  }
}

object ClassReflection extends App {
  val p = ru.typeOf[CustomerActor]
  val splitPackageName = p.typeSymbol.fullName split ('.')
  val rebuiltPackageName = splitPackageName.init.mkString(".")
  println(s"Package: $rebuiltPackageName")
  println(s"Type: ${p.typeSymbol.name}")
  val fieldSymbols = p.declarations.filter(!_.isMethod).toList
  fieldSymbols.foreach(x => println(s"Field: ${x.name}"))
  val methodSymbols = p.declarations.filter(_.isMethod).toList
  methodSymbols.foreach(x => println(s"Method: ${x.name}"))
}