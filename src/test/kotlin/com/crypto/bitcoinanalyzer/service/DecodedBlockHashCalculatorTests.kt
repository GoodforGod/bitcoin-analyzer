package com.crypto.bitcoinanalyzer.service

import com.crypto.bitcoinanalyzer.model.Block
import com.crypto.bitcoinanalyzer.service.impl.DecodedBlockHashCalculator
import com.crypto.bitcoinanalyzer.service.impl.SubstringService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Duration

/**
 * @author Anton Kurako (GoodforGod)
 * @since 26.2.2021
 */
class DecodedBlockHashCalculatorTests : Assertions() {

    private val calculator: BlockHashCalculator = DecodedBlockHashCalculator(SubstringService())

    @Test
    fun `calculate existing sub hash for blocks`() {
        val blocks = listOf(
            Block(646940L, 1, 1, "0000000000000000000b08b64f625bf4c51d0a34ebaef2b7451c0840149f7ff6"),
            Block(646941L, 1, 2, "0000000000000000000ecb9d7b39484bab8bde23859ce59a22ffef46735fe95f")
        )

        val subHashByRange = calculator.getLongestSubHash(blocks).block(Duration.ofSeconds(5))
        assertEquals("2989", subHashByRange)
    }

    @Test
    fun `calculate non existing sub hash for blocks`() {
        val blocks = listOf(
            Block(646941L, 1, 1, "62"),
            Block(646942L, 1, 2, "15")
        )

        val def = "DEF CAUSE EMPTY"
        val subHashByRange = calculator.getLongestSubHash(blocks).defaultIfEmpty(def).block(Duration.ofSeconds(5))
        assertEquals(def, subHashByRange)
    }
}