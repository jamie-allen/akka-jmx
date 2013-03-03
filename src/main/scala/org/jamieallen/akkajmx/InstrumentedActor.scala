package org.jamieallen.akkajmx

import akka.actor.Actor
import javax.management.ObjectName

trait InstrumentedActor extends Actor {
  def objectName: ObjectName = new ObjectName(s"${context.system}:name=${context.self.path}")
}