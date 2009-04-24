require gst-plugins.inc
PR = "r0"

DEPENDS += "gst-plugins-base ${@get_depends(bb, d)}"
SRC_URI += "${@get_src_uri(bb, d)}"

def get_src_uri(bb, d):
	if bb.data.getVar('DISTRO', d, 1) in [ 'opendreambox' ]:
		return ""
	return "file://gstmad_16bit.patch;patch=1 " \
		"file://gstsid_autofoo_HACK.patch;patch=1"

def get_depends(bb, d):
	if bb.data.getVar('DISTRO', d, 1) in [ 'opendreambox' ]:
		return ""
	return "libsidplay"
