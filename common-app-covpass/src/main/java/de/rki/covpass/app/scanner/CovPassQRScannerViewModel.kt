/*
 * (C) Copyright IBM Deutschland GmbH 2021
 * (C) Copyright IBM Corp. 2021
 */

package de.rki.covpass.app.scanner

import com.ensody.reactivestate.BaseReactiveState
import com.ensody.reactivestate.StateFlowStore
import com.ensody.reactivestate.getData
import com.ibm.health.common.android.utils.BaseEvents
import de.rki.covpass.app.dependencies.covpassDeps
import de.rki.covpass.sdk.storage.CertRepository
import de.rki.covpass.sdk.cert.QRCoder
import de.rki.covpass.sdk.cert.models.CombinedCovCertificate
import de.rki.covpass.sdk.cert.models.CovCertificate
import de.rki.covpass.sdk.cert.models.GroupedCertificatesId
import de.rki.covpass.sdk.dependencies.sdkDeps
import kotlinx.coroutines.CoroutineScope

/**
 * Interface to communicate events from [CovPassQRScannerViewModel] to [CovPassQRScannerFragment].
 */
internal interface CovPassQRScannerEvents : BaseEvents {
    fun onScanSuccess(certificateId: GroupedCertificatesId)
}

/**
 * ViewModel holding the business logic for decoding the [CovCertificate].
 */
internal class CovPassQRScannerViewModel(
    scope: CoroutineScope,
    store: StateFlowStore,
    private val qrCoder: QRCoder = sdkDeps.qrCoder,
    private val certRepository: CertRepository = covpassDeps.certRepository,
) : BaseReactiveState<CovPassQRScannerEvents>(scope) {

    val lastCertificateId by store.getData<GroupedCertificatesId?>(null)

    fun onQrContentReceived(qrContent: String) {
        launch {
            val covCertificate = qrCoder.decodeCovCert(qrContent)
            val certsFlow = certRepository.certs
            var certId: GroupedCertificatesId? = null
            certsFlow.update {
                certId = it.addNewCertificate(
                    CombinedCovCertificate(
                        covCertificate,
                        qrContent,
                        System.currentTimeMillis()
                    )
                )
            }
            certId?.let {
                lastCertificateId.value = it
                eventNotifier {
                    onScanSuccess(it)
                }
            }
        }
    }
}
