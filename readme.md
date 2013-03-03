# Akka JMX

## Overview
This is an attempt to use Scala 2.10 macros to write the code to register Akka actors as JMX MBeans without any muss and fuss by the developer.  JMX instrumentation without the hassle.

## Concept
The macro will introspect on actor classes and create an MBean definition that exposes the actors internal state.  It will use the actor's Akka ID (shown when you call toString() on an actor) to register the actor, using the ActorSystem as the JMX Domain and the path to the actor as the objectName.

The registration of the actor's will use a common Singleton proxy object that will handle all of the failure cases.

##License
This code is open source software licensed under the <a href="http://www.apache.org/licenses/LICENSE-2.0.html">Apache 2.0 License</a>.