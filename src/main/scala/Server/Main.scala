package Server

import java.net.{InetAddress, InetSocketAddress}

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.util.ByteString

object Main {
  def main(args: Array[String]): Unit = {

    val host = InetAddress.getLocalHost
    val ip = host.getHostAddress
    val port = 2351
    println(s"Server started! listening to $ip:$port")

    val serverProps = TcpServer.props(new InetSocketAddress(host, port))
    println("aaa")
    val actorSystem: ActorSystem = ActorSystem.create("MyActorSystem")
    println("aaa")
    val serverActor: ActorRef = actorSystem.actorOf(serverProps)
    println("aaa")
    serverActor ! ByteString("Starting server...")
    println("aaa")
  }
}