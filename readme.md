# Akka JMX

## Overview
This is an attempt to use type macros to create an MBean definition for an Akka actor created by an application developer, automatically register the actor when it is created at runtime and unregister when the actor is stopped.  The idea is to provide easy, runtime instrumentation of Akka-based actor applications to support production debugging.

## Concept
The type macro will introspect on actor classes and create an MBean definition that exposes the actors internal fields.  It will use the actor's Akka ID (shown when you call toString() on an actor) to register the actor, using the ActorSystem as the JMX Domain and the path to the actor as the objectName.

The registration of the actor's will use a common Singleton proxy object that will handle all of the failure cases.

##License
This code is open source software licensed under the <a href="http://www.apache.org/licenses/LICENSE-2.0.html">Apache 2.0 License</a>.