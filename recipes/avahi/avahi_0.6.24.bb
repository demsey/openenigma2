require avahi.inc

#LIBTOOL = "${TARGET_SYS}-libtool"
#EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"
PR = "r1"

DEPENDS += "intltool-native"

PACKAGES =+ "libavahi-gobject"
