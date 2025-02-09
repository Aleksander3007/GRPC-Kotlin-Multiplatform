package io.github.timortel.kotlin_multiplatform_grpc_lib

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder

actual class KMChannel private constructor(val managedChannel: ManagedChannel) {
    actual class Builder(private val impl: ManagedChannelBuilder<*>) {

        actual companion object {
            actual fun forAddress(
                name: String,
                port: Int
            ): Builder {
                return Builder(ManagedChannelBuilder.forAddress(name, port))
            }

            actual fun forTarget(target: String): Builder {
                return Builder(ManagedChannelBuilder.forTarget(target))
            }
        }

        actual fun usePlaintext(): Builder = apply {
            impl.usePlaintext()
        }

        actual fun build(): KMChannel = KMChannel(impl.build())
    }
}