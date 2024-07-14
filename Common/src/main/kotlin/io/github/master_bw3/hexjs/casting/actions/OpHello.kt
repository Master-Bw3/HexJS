package io.github.master_bw3.hexjs.casting.actions

import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.eval.sideeffects.OperatorSideEffect
import at.petrak.hexcasting.api.casting.eval.vm.CastingImage
import at.petrak.hexcasting.api.casting.eval.vm.SpellContinuation
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.NullIota
import at.petrak.hexcasting.api.casting.mishaps.MishapNotEnoughArgs
import at.petrak.hexcasting.common.lib.hex.HexEvalSounds
import net.minecraft.text.Text
import at.petrak.hexcasting.api.casting.eval.OperationResult as OperationResult1

object OpHello : Action {
    override fun operate(env: CastingEnvironment, image: CastingImage, continuation: SpellContinuation): OperationResult1 {
        val stack = image.stack.toMutableList()

        val image2 = image.withUsedOp().copy(stack = stack)
        return OperationResult1(
            image2,
            listOf(
                OperatorSideEffect.AttemptSpell(Spell(NullIota()), hasCastingSound = false, awardStat = false)
            ),
            continuation,
            HexEvalSounds.SPELL,
        )
    }

    private data class Spell(val datum: Iota) : RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            env.printMessage(Text.literal("hello"))
        }
    }
}