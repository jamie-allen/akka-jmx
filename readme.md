# Akka JMX

## Overview
This is an attempt to use type macros to create an MBean definition for an Akka actor created by an application developer, automatically register the actor when it is created at runtime and unregister when the actor is stopped.  The idea is to provide easy, runtime instrumentation of Akka-based actor applications to support production debugging.

## Motivation
The Typesafe Console is *awesome*, but it only gives you information about the non-functional performance of your Akka actors at runtime.  It is my belief that every developer creating an Akka application should be using JMX to expose the internal state of their actors, so that they have as much information as possible about what's happening in the application at runtime.  However, almost no one seems willing to take the time to create MBean traits for each Actor type they create.  What if we could generate them for them?

The key is to use type macros, from Eugene Burmako's <a href="http://docs.scala-lang.org/overviews/macros/paradise.html">Macro Paradise"</a> project.  There is a stumbling point here, in that Macro Paradise requires Scala 2.11.0-SNAPSHOT and the Akka project is not yet built against that version.  I'd rather not build my own version of Akka for this, but I might have to.

## Concept
The type macro will introspect on actor classes and create an MBean definition that exposes the actors internal fields.  It will use the actor's Akka ID (shown when you call toString() on an actor) to register the actor, using the ActorSystem as the JMX Domain and the path to the actor as the objectName.

The registration of the actor's will use a common Singleton proxy object that will handle all of the failure cases.

##License
This code is open source software licensed under the <a href="http://www.apache.org/licenses/LICENSE-2.0.html">Apache 2.0 License</a>.