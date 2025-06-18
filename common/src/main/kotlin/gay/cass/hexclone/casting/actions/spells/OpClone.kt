package gay.cass.hexclone.casting.actions.spells

import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.misc.MediaConstants
import at.petrak.hexcasting.api.casting.getEntity
import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.utils.asTranslatedComponent
import net.minecraft.world.entity.Entity
import net.minecraft.world.phys.Vec3

object OpClone : SpellAction {
    override val argc = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val target = args.getEntity(0, argc)
        env.assertEntityInRange(target)

        return SpellAction.Result(
            Spell(target),
            (10.0 * MediaConstants.DUST_UNIT).toLong(),
            listOf(ParticleSpray(target.position().add(0.0, target.eyeHeight.toDouble(), 0.0), Vec3(0.0, 0.5, 0.0), 0.1, 1.0472))
        )
    }

    private data class Spell(val target: Entity) : RenderedSpell {
        // IMPORTANT: do not throw mishaps in this method! mishaps should ONLY be thrown in SpellAction.execute
        override fun cast(env: CastingEnvironment) {
            TODO("make the spell actually create a second turing tape, as it were")
        }
    }
}
