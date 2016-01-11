package com.github.haretaro.weasel.common

import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.client.lib.{Topic, Utterance}
import Topic._
import org.aiwolf.common.data.{Talk, Agent}
import org.aiwolf.common.net.{GameSetting, GameInfo}
import scala.collection.convert.WrapAsScala._

trait BasePlayer extends AbstractRole{

  var readTalkNum = 0
  var readWhisperNum = 0
  var voteMap = Map.empty[Agent,Agent]

  /** 生きているエージェントのリストを取得 */
  def aliveAgents = gameInfo.getAliveAgentList

  def gameInfo = getGameInfo(getDay)

  override def initialize(gameInfo:GameInfo, gameSetting:GameSetting):Unit = {
  }

  override def dayStart:Unit = {
  }

  override def finish:Unit = {}

  //得票数の一番多いエージェントを返す
  def majorityOpinion: Option[Agent] = voteMap
    .values
    .groupBy(a=>a).map{
      case (k,v) => (k,v.size)
    }
    .toSeq.sortBy(_._2) match{
      case (k,v) :: _ => Some(k)
      case _ => None
    }

  override def update(gameInfo:GameInfo):Unit = {

    val talks = gameInfo.getTalkList

    talks.drop(readTalkNum).foreach(t=>{

      val utterance = new Utterance(t.getContent)

      utterance.getTopic match{

        case VOTE => {
          val agent = t.getAgent
          val target = utterance.getTarget
          voteMap = voteMap + (agent->target)
        }

        case DIVINED => {
          println("divined")
        }

        case _ =>

      }
    })
    readTalkNum = talks.size
  }

}
