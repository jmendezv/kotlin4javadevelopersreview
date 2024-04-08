package edu.jmendezv.kotlin4javadevelopersreview._04_clasesyobjetos

const val LIMITE_CREDITO_GOLDEN = 3000.0
const val LIMITE_CREDITO_PLATINUM = 6000.0

sealed class LimiteCredito(val limite: Double) {
    class LimiteCreditoGolden : LimiteCredito(LIMITE_CREDITO_GOLDEN)
    class LimiteCreditoPlatinum : LimiteCredito(LIMITE_CREDITO_PLATINUM)
}