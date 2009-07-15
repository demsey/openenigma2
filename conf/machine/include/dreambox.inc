# dreambox.inc

EXTRA_IMAGEDEPENDS += "dreambox-secondstage dreambox-buildimage-native"

GLIBC_ADDONS ?= "ports,nptl,libidn"
GLIBC_EXTRA_OECONF ?= "--disable-profile --with-tls --without-fp --with-__thread"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "dreambox-dvb-modules"
MACHINE_FEATURES += "kernel26"

PREFERRED_PROVIDER_virtual/kernel = "linux-${MACHINE}"
PREFERRED_PROVIDER_xserver = "xserver-kdrive"

