# dreambox-mipsel.inc

MACHINE_FEATURES += "alsa pci wifi"

PREFERRED_PROVIDER_task-opendreambox-dvbapi = "task-opendreambox-dvbapi3"
PREFERRED_PROVIDER_task-opendreambox-ui = "task-opendreambox-enigma2"

TARGET_ARCH = "mipsel"
TARGET_FPU = "soft"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-mips32.inc
