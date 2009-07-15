DESCRIPTION = "OpenDreambox: Base Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r1"

inherit task

#
# task-opendreambox-base
#
DESCRIPTION_${PN} = "OpenDreambox: Basesystem utilities"

OPENDREAMBOX_BASE_ESSENTIAL = "\
  autofs \
  base-files-doc \
  dreambox-bootlogo \
  dreambox-compat \
  dreambox-dccamd \
  dreambox-feed-configs \
  dreambox-keymaps \
  dropbear \
  dvbsnoop \
  e2fsprogs-e2fsck \
  e2fsprogs-mke2fs \
  fakelocale \
  netkit-base \
  opkg-nogpg \
  timezones-alternative \
  tuxbox-common \
  util-linux-sfdisk \
  vsftpd \
"

OPENDREAMBOX_BASE_OPTIONAL = "\
  gdbserver \
  hddtemp \
  joe \
  mc \
  mrouted \
  ppp \
  smartmontools \
"

RDEPENDS_${PN} = "\
	${OPENDREAMBOX_BASE_ESSENTIAL} \
	${OPENDREAMBOX_BASE_OPTIONAL} \
"

RDEPENDS_${PN}_dm7025 = "\
	${OPENDREAMBOX_BASE_ESSENTIAL} \
"

