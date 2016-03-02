package com.github.haretaro.weasel

import com.github.haretaro.weasel.role.{Medium, Villager}
import org.aiwolf.client.base.player.AbstractRoleAssignPlayer

/**
 * @author Haretaro
 */
class Weasel extends AbstractRoleAssignPlayer{
  
  setVillagerPlayer(new Villager)
  setMediumPlayer(new Medium)
  override def getName:String = "Weasel"

}
