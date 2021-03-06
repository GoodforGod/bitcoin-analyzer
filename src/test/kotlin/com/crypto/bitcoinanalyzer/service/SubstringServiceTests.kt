package com.crypto.bitcoinanalyzer.service

import com.crypto.bitcoinanalyzer.service.impl.SubstringService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author GoodforGod
 * @since 27.02.2021
 */
class SubstringServiceTests : Assertions() {

    private val substringService: SubstringService = SubstringService()

    @Test
    fun `substring found when exist`() {
        val strs = listOf(
            "1056850286200300937094298967488490265669752758871228406",
            "1417115074586831187112255580375243348964882211567298911"
        )

        assertEquals("2989", substringService.longestSubstring(strs))
    }

    @Test
    fun `substring not found when not exist`() {
        val strs = listOf("12345", "6789")
        assertTrue(substringService.longestSubstring(strs).isEmpty())
    }
}