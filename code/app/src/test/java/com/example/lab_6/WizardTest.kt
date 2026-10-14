package com.example.lab_6

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }
    @Test
    fun castSpell_explosion_unsuccessful() {
        evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(0, damageDealt)

        assertEquals(5, evilWizard.mana) // mana still is 5
    }
    //tests for a frostbite spell success
    @Test
    fun castSpell_frostbite_successful(){
        evilWizard.mana = 10
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20,damageDealt)

        assertEquals(5, evilWizard.mana)
    }
    //tests for an unsuccessful frostbite spell
    @Test
    fun castSpell_frostbite_unsuccessful(){
        evilWizard.mana = 2
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(0,damageDealt)

        assertEquals(2, evilWizard.mana)
    }
}