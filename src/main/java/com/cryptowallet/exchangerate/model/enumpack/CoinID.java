package com.cryptowallet.exchangerate.model.enumpack;

public enum CoinID {
    TRON("trx-tron"), BITCOIN ("btc-bitcoin"), ETHEREUM ("eth-ethereum"), TETHER ("usdt-tether"),
    XRP ("xrp-xrp"), BITCOIN_CASH ("bch-bitcoin-cash"), BITCOIN_SV ("bsv-bitcoin-sv"), LITECOIN ("ltc-litecoin"),
    EOS ("eos-eos"), BINANCE_COIN ("bnb-binance-coin"), TEZOS ("xtz-tezos"), CARDANO ("ada-cardano"),
    OKB ("okb-okb"), CHAIN_LINK ("link-chainlink"), STELLAR ("xlm-stellar"), MONERO ("xmr-monero"),
    CRYPTO_COM_COIN ("cro-cryptocom-chain"), LEO_TOKEN ("leo-leo-token"), HUOBI_TOKEN ("ht-huobi-token"),
    ETHEREUM_CLASSIC ("etc-ethereum-classic");

    private String value;

    CoinID(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
