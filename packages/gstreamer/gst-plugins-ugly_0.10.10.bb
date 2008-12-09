require gst-plugins.inc
PR = "r0"

DEPENDS += "gst-plugins-base ${@base_conditional('DISTRO', 'opendreambox', '', 'libsidplay', d)}"
SRC_URI += "${@base_conditional('DISTRO', 'opendreambox', '', \
	'file://gstmad_16bit.patch;patch=1 \
	file://gstsid_autofoo_HACK.patch;patch=1', d)}"

LIBTOOL = "${TARGET_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

python() {
	enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
	if enterprise == "1":
		raise bb.parse.SkipPackage("gst-plugins-ugly will only build if ENTERPRISE_DISTRO != 1")
}
