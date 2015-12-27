package com.github.haretaro.weasel

import com.github.haretaro.weasel.role.Villager
import org.aiwolf.client.base.player.AbstractRoleAssignPlayer

/**
 * @author Haretaro
 */
class Weasel extends AbstractRoleAssignPlayer{
  
  setVillagerPlayer(new Villager)
  override def getName:String = "Weasel"
}
