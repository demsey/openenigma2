# dreambox-mipsel.inc

MACHINE_FEATURES += "alsa pci"

OLDEST_KERNEL = "2.6.12"

PREFERRED_PROVIDER_task-opendreambox-dvbapi = "task-opendreambox-dvbapi3"
PREFERRED_PROVIDER_task-opendreambox-ui = "task-opendreambox-enigma2"

TARGET_ARCH = "mipsel"
TARGET_FPU ?= "soft"

DISTRO_FEATURES += " mplt"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc
