package com.github.haretaro.weasel.role

import org.aiwolf.client.base.player.AbstractVillager
import org.aiwolf.common.data.Agent
import org.aiwolf.common.data.Talk

/**
 * @author Haretaro
 */
class Villager extends AbstractVillager{
  override def dayStart:Unit = {}
  override def finish:Unit = {}
  override def talk:String = Talk.SKIP
  override def vote:Agent = null
}