package com.crypto.bitcoinanalyzer.service.impl

import com.crypto.bitcoinanalyzer.client.BtcClient
import com.crypto.bitcoinanalyzer.model.btc.BtcBlock
import com.crypto.bitcoinanalyzer.service.BlockchainProvider
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

/**
 * @author Anton Kurako (GoodforGod)
 * @since 25.2.2021
 */
@Qualifier("bitcoin")
@Service
class BitcoinProvider(private val btcClient: BtcClient) : BlockchainProvider<BtcBlock> {

    /**
     * We can implement caching logic here to improve performance or something else
     */
    override fun getBlocks(heights: Collection<Long>): Flux<BtcBlock> {
        return btcClient.getBlocks(heights)
            .map { it }
    }
}