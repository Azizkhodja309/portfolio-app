package com.azizkhodja.portfolio.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.azizkhodja.portfolio.R
import com.azizkhodja.portfolio.databinding.FragmentContactBinding
import com.azizkhodja.portfolio.databinding.ItemContactBinding

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindContact(
            binding.itemEmail,
            iconRes = R.drawable.ic_email,
            label = getString(R.string.contact_email_label),
            value = getString(R.string.contact_email_value)
        ) { openEmail(getString(R.string.contact_email_value)) }

        bindContact(
            binding.itemPhone,
            iconRes = R.drawable.ic_phone,
            label = getString(R.string.contact_phone_label),
            value = getString(R.string.contact_phone_value)
        ) { dialPhone(getString(R.string.contact_phone_value)) }

        bindContact(
            binding.itemTelegram,
            iconRes = R.drawable.ic_telegram,
            label = getString(R.string.contact_telegram_label),
            value = getString(R.string.contact_telegram_value)
        ) { openUrl("https://t.me/azizkhodja") }

        bindContact(
            binding.itemGithub,
            iconRes = R.drawable.ic_github,
            label = getString(R.string.contact_github_label),
            value = getString(R.string.contact_github_value)
        ) { openUrl("https://" + getString(R.string.contact_github_value)) }

        bindContact(
            binding.itemLinkedin,
            iconRes = R.drawable.ic_linkedin,
            label = getString(R.string.contact_linkedin_label),
            value = getString(R.string.contact_linkedin_value)
        ) { openUrl("https://" + getString(R.string.contact_linkedin_value)) }
    }

    private fun bindContact(
        item: ItemContactBinding,
        iconRes: Int,
        label: String,
        value: String,
        action: () -> Unit
    ) {
        item.contactIcon.setImageResource(iconRes)
        item.contactLabel.text = label
        item.contactValue.text = value
        item.root.setOnClickListener { action() }
    }

    private fun openUrl(url: String) {
        safeStart(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun openEmail(email: String) {
        safeStart(Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")))
    }

    private fun dialPhone(phone: String) {
        val cleaned = phone.replace(" ", "")
        safeStart(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$cleaned")))
    }

    private fun safeStart(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.localizedMessage ?: "Error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
