require avahi.inc

LIBTOOL = "${TARGET_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

DEPENDS += "intltool-native"

PACKAGES =+ "libavahi-gobject"
