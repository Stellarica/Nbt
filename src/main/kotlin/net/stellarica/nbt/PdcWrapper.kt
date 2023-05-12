package net.stellarica.nbt

import net.minecraft.nbt.CompoundTag
import org.bukkit.craftbukkit.v1_19_R3.persistence.CraftPersistentDataContainer
import org.bukkit.persistence.PersistentDataContainer

fun PersistentDataContainer.getCompoundTag(): CompoundTag {
	return (this as CraftPersistentDataContainer).toTagCompound()
}

fun PersistentDataContainer.setCompoundTag(value: CompoundTag) {
	(this as CraftPersistentDataContainer).clear()
	this.putAll(value)
}