package com.github.haretaro.weasel.role

import org.aiwolf.client.base.player.AbstractVillager
import org.aiwolf.client.lib._
import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk
import org.aiwolf.common.net._
import scala.collection.convert.WrapAsScala._

/**
 * @author Haretaro
 */
class Villager extends AbstractVillager{
  
  var readTalkNum = 0
  
  private def aliveAgents = getGameInfo(getDay).getAliveAgentList
  
  override def dayStart:Unit = {}
  
  override def finish:Unit = {}
  
  override def initialize(gameInfo:GameInfo, gameSetting:GameSetting):Unit = {
  }
  
  override def talk:String = Talk.SKIP
  
  override def update(gameInfo:GameInfo):Unit = {
    val talks = gameInfo.getTalkList
    talks.drop(readTalkNum).foreach(t=>{
      println(t.getIdx)
    })
    readTalkNum = talks.size
  }
  
  override def vote:Agent = null
}