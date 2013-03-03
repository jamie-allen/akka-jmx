package org.jamieallen.akkajmx

import scala.reflect.runtime.{ universe => ru }

case class Person(name: String, var address: String)

object ClassReflection extends App {
  val p = ru.typeOf[Person]
  val fieldSymbols = p.declarations.filter(!_.isMethod).toList
  fieldSymbols.foreach(x => println(s"Field: ${x.name}"))
  val methodSymbols = p.declarations.filter(_.isMethod).toList
  methodSymbols.foreach(x => println(s"Method: ${x.name}"))
}