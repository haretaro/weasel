package com.github.haretaro.weasel.informationManagement

import org.aiwolf.client.lib.{Topic, Utterance}
import org.aiwolf.common.data.{Talk, Agent, Role}
import org.aiwolf.common.net.GameInfo
import scala.collection.convert.WrapAsScala._

/**
  * @author Haretaro
  */
case class GameInformation(val me: Agent) extends InformationManager{

  /**
    * 噛まれて死んだエージェント
    */
  var attackedAgents = Set.empty[Agent]

  /**
    * カミングアウト情報
    */
  var comingouts = Set.empty[Comingout]

  var readTalkNum = 0

  override def update(gameInfo: GameInfo): Unit = {
    val talks = gameInfo.getTalkList
    talks.drop(readTalkNum)
      .foreach(t => listen(t))
    readTalkNum = talks.size

    if(gameInfo.getAttackedAgent != null) attackedAgents = attackedAgents + gameInfo.getAttackedAgent

    def listen(talk: Talk): Unit = {
      val utterance = new Utterance(talk.getContent)
      utterance.getTopic match{

        case Topic.COMINGOUT => {
          val co = Comingout(talk.getAgent, utterance.getRole)
          comingouts.find(_.who.equals(co.who)).foreach(c => comingouts = comingouts - c)
          comingouts = comingouts + co
        }

        case _ =>
      }
    }
  }

}

case class Comingout(who: Agent, role: Role)

case class Player(who: Agent, comingout: Option[Role], isWhite: Option[Boolean])
