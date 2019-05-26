package Client

import java.net.{InetAddress, InetSocketAddress}

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.ByteString

object Main {
  def main(args: Array[String]): Unit = {
    val host = InetAddress.getLocalHost
    val port = 8080
    println(s"Started client! connecting to ${host}:${port}")

    val clientProps = Props(classOf[TcpClient], new InetSocketAddress(host, port), null)

    val actorSystem: ActorSystem = ActorSystem.create("MyActorSystem")
    val clientActor: ActorRef = actorSystem.actorOf(clientProps)

    Thread.sleep(2000)
    clientActor ! ByteString("hello from client")
  }
}