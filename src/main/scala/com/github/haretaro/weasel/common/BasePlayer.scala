package com.github.haretaro.weasel.common

import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.common.data.{Talk, Agent}
import org.aiwolf.common.net.{GameSetting, GameInfo}

trait BasePlayer extends AbstractRole{

  var readTalkNum = 0
  var readWhisperNum = 0
  var votemap = Map.empty[Agent,Option[Agent]]

  /** 生きているエージェントのリストを取得 */
  def aliveAgents = getGameInfo(getDay).getAliveAgentList

  override def initialize(gameInfo:GameInfo, gameSetting:GameSetting):Unit = {
  }

  override def dayStart:Unit = {
  }

  override def finish:Unit = {}

  override def update(gameInfo:GameInfo):Unit = {
    val talks = gameInfo.getTalkList
    talks.drop(readTalkNum).foreach(t => println(t.getIdx))
    readTalkNum = talks.size
  }

}