# dreambox-mipsel.inc

MACHINE_FEATURES += "alsa pci wifi"

PREFERRED_VERSION_linux-libc-headers = "2.6.12.0"
PREFERRED_PROVIDER_task-opendreambox-dvbapi = "task-opendreambox-dvbapi3"
PREFERRED_PROVIDER_task-opendreambox-ui = "task-opendreambox-enigma2"

TARGET_ARCH = "mipsel"
TARGET_FPU = "soft"

require conf/machine/include/dreambox.inc
