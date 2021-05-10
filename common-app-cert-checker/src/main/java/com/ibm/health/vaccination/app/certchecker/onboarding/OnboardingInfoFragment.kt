package com.ibm.health.vaccination.app.certchecker.onboarding

import com.ibm.health.common.vaccination.app.onboarding.BaseOnboardingConsentFragment
import com.ibm.health.common.vaccination.app.onboarding.BaseOnboardingInfoFragment
import com.ibm.health.vaccination.app.certchecker.R

internal abstract class CommonOnboardingInfoFragment : BaseOnboardingInfoFragment() {
    override val buttonTextRes = R.string.next_onboarding_page_button_title
}

internal class OnboardingInfo1Fragment : CommonOnboardingInfoFragment() {
    override val titleRes = R.string.validation_first_onboarding_page_title
    override val textRes = R.string.validation_first_onboarding_page_message
    override val imageRes = R.drawable.onboarding_info_validation_1
}

internal class OnboardingInfo2Fragment : CommonOnboardingInfoFragment() {
    override val titleRes = R.string.validation_second_onboarding_page_title
    override val textRes = R.string.validation_second_onboarding_page_message
    override val imageRes = R.drawable.onboarding_info_validation_2
}

internal class OnboardingConsentFragment : BaseOnboardingConsentFragment() {
    override val titleRes = R.string.validation_fourth_onboarding_page_title
    override val textRes = R.string.validation_fourth_onboarding_page_message
    override val imageRes = R.drawable.onboarding_consent_validation
    override val buttonTextRes = R.string.confirmation_fourth_onboarding_page_button_title
    override val dataProtectionLinkRes = R.string.on_boarding_consent_data_protection_link
}