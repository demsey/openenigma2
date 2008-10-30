# dreambox-mipsel.inc

MACHINE_FEATURES += "alsa pci wifi"

PREFERRED_VERSION_linux-libc-headers = "2.6.12.0"

TARGET_ARCH = "mipsel"
TARGET_FPU = "soft"

require conf/machine/include/dreambox.inc
