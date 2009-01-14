DESCRIPTION = "OpenDreambox: Base Task for the OpenDreambox Distribution"
SECTION = "opendreambox/base"
LICENSE = "MIT"
PR = "r0"

inherit task

#
# task-opendreambox-base
#
DESCRIPTION_${PN} = "OpenDreambox: Basesystem utilities"
RDEPENDS_${PN} = "\
  opkg-nogpg \
  dropbear \
  ncurses \
  joe \
  mc \
  vsftpd \
  timezones-alternative \
  netkit-base \
  fakelocale \
  dreambox-bootlogo \
  dreambox-dccamd \
  dreambox-keymaps \
  dvbsnoop \
  dreambox-compat \
  tuxbox-common \
  mrouted \
  smartmontools \
  hddtemp \
  autofs \
  gdbserver \
  dreambox-feed-configs \
  util-linux-sfdisk \
  util-linux-fdisk \
  e2fsprogs-mke2fs \
  e2fsprogs-e2fsck \
  ppp \
  module-init-tools-depmod \
  base-files-doc \
"

