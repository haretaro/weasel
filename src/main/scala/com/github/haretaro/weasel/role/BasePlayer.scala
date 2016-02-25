package com.github.haretaro.weasel.role

import org.aiwolf.client.base.player.AbstractRole
import org.aiwolf.client.lib.Topic._
import org.aiwolf.client.lib.{Topic, Utterance}
import org.aiwolf.common.data.Agent
import org.aiwolf.common.net.{GameInfo, GameSetting}

import scala.collection.convert.WrapAsScala._

trait BasePlayer extends AbstractRole{

  /** 生きているエージェントのリストを取得 */
  def aliveAgents = gameInfo.getAliveAgentList

  override def initialize(gameInfo:GameInfo, gameSetting:GameSetting):Unit = {
  }

  override def dayStart:Unit = {
  }

  override def finish:Unit = {}

  override def update(gameInfo:GameInfo):Unit = {}
}
