package org.jamieallen.akkajmx

import java.lang.management.ManagementFactory
import javax.management.ObjectName
import scala.util.Try
import javax.management.{ InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, RuntimeOperationsException, InstanceNotFoundException }

object MBeanServerProxy {
  val mbeanServer = ManagementFactory.getPlatformMBeanServer

  // TODO: Figure out what to do when registration/unregistration fails

  def register(actor: InstrumentedActor): Unit = {
    Try { mbeanServer.registerMBean(actor, actor.objectName) } recover {
      case iaee: InstanceAlreadyExistsException => ???
      case mbre: MBeanRegistrationException => ???
      case ncme: NotCompliantMBeanException => ???
      case roe: RuntimeOperationsException => ???
    }
  }

  def unregister(actor: InstrumentedActor): Unit = {
    Try { mbeanServer.unregisterMBean(actor.objectName) } recover {
      case infe: InstanceNotFoundException => ???
      case mre: MBeanRegistrationException => ???
    }
  }
}