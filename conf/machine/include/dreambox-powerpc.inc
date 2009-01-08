# dreambox-powerpc.inc

PACKAGE_EXTRA_ARCHS = "ppc405"

PREFERRED_VERSION_gdb = "6.5"
PREFERRED_VERSION_gdb-cross = "6.5"
PREFERRED_VERSION_freetype = "2.0.9"

TARGET_ARCH = "powerpc"
TARGET_CPU = "405"

EXTRA_IMAGECMD_jffs2 = " --eraseblock=0x4000 -n -b "
IMAGE_CMD_jffs2 = "mkfs.jffs2 --root=${IMAGE_ROOTFS}/boot --faketime -x lzo \
       --output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
       ${EXTRA_IMAGECMD}; rm -rf ${IMAGE_ROOTFS}/boot/*; \
				mkfs.jffs2 --root=${IMAGE_ROOTFS} --faketime -x lzo \
       --output=${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
       ${EXTRA_IMAGECMD}; \
       buildimage ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz \
       ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.boot.jffs2 \
       ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2 \
       ${MACHINE} \
       > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.nfi"

require conf/machine/include/dreambox.inc
require conf/machine/include/tune-ppc405.inc
