# dreambox.inc

EXTRA_IMAGEDEPENDS += "dreambox-secondstage dreambox-buildimage-native"

GLIBC_ADDONS = "ports,nptl,libidn"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "dreambox-dvb-modules"
MACHINE_FEATURES += "kernel26 keyboard screen usbhost"

OLDEST_KERNEL = "2.6.9"

PREFERRED_PROVIDER_virtual/kernel = "linux-${MACHINE}"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"

