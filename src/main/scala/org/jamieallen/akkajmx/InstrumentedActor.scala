package org.jamieallen.akkajmx

import akka.actor.Actor
import javax.management.ObjectName

trait InstrumentedActor extends Actor {
  def objectName: ObjectName = new ObjectName(s"${context.system}:name=${context.self.path}")

  // TODO: Figure out how to add the extends/with information for the generated actor MBean 
  //       to the type signature of the actor implementing this trait.

  // TODO: I *really* do not want to register "this", as it introduces concurrency issues 
  //       by exposing a way for another thread to call into the actor directly.  Actors
  //       should NEVER have any thread other than that given from their dispatcher for
  //       message processing.  But I'm doing this now to show my intent.
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = MBeanServerProxy.register(this)
  override def postStop(): Unit = MBeanServerProxy.unregister(this)
}