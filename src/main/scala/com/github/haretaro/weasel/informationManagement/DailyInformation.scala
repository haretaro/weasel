package com.github.haretaro.weasel.informationManagement

import org.aiwolf.client.lib.{Topic, Utterance}
import org.aiwolf.common.data.{Talk, Agent}
import org.aiwolf.common.net.GameInfo
import scala.collection.convert.WrapAsScala._

/**
  * 一日毎の情報を管理するクラス
  * @author Haretaro
  */
class DailyInformation extends InformationManager {
  //TODO: 日付が変わっていたら自分で初期化させる

  var readTalkNum = 0
  var votes = Set.empty[Vote]

  override def update(gameInfo: GameInfo) = {
    val talks = gameInfo.getTalkList
    talks.drop(readTalkNum)
      .filter(t => t.getDay == gameInfo.getDay)
      .foreach(t => listen(t))
    readTalkNum = talks.size
  }

  def listen(talk: Talk): Unit = {
    val utterance = new Utterance(talk.getContent)
    utterance.getTopic match{
      case Topic.VOTE => {
        val vote = Vote(talk.getAgent, utterance.getTarget)
        votes.find(v => v.from.equals(talk.getAgent)).foreach(v => votes = votes - v)
        votes = votes + vote
      }
      case _ =>
    }
  }

  /**
    * @return 現在最も票を集めているエージェント
    */
  def potentialCandidate: Option[Agent] = {
    votes.groupBy(v => v.to)
      .map{case (agent, votes) => (agent, votes.size)}
      .toSeq
      .sortBy(_._2)
      .reverse
      .map(_._1)
      .headOption
  }

}

case class Vote(from: Agent, to: Agent)
