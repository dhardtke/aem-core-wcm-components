/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2021 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~   http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.adobe.cq.wcm.core.components.internal.models.v3;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.adobe.cq.wcm.core.components.Utils;
import com.adobe.cq.wcm.core.components.internal.models.v1.AbstractImageTest;
import com.adobe.cq.wcm.core.components.internal.servlets.AdaptiveImageServlet;
import com.adobe.cq.wcm.core.components.models.Image;
import com.adobe.cq.wcm.core.components.models.ImageArea;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static com.adobe.cq.wcm.core.components.internal.link.LinkTestUtils.assertValidLink;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class ImageImplTest extends com.adobe.cq.wcm.core.components.internal.models.v2.ImageImplTest {

    private static String TEST_BASE = "/image/v3";
    private static final String IMAGE50_PATH = PAGE + "/jcr:content/root/image50";
    private static final String IMAGE51_PATH = PAGE + "/jcr:content/root/image51";
    private static final String IMAGE52_PATH = PAGE + "/jcr:content/root/image52";
    private static final String IMAGE53_PATH = PAGE + "/jcr:content/root/image53";
    private static final String IMAGE54_PATH = PAGE + "/jcr:content/root/image54";
    private static final String IMAGE55_PATH = PAGE + "/jcr:content/root/image55";
    private static final String IMAGE56_PATH = PAGE + "/jcr:content/root/image56";
    private static final String IMAGE57_PATH = PAGE + "/jcr:content/root/image57";
    private static final String IMAGE58_PATH = PAGE + "/jcr:content/root/image58";

    private static String PAGE0 = TEST_ROOT + "/test_page0";
    private static String PAGE1 = TEST_ROOT + "/test_page1";
    private static String PAGE2 = TEST_ROOT + "/test_page2";
    private static String PAGE3 = TEST_ROOT + "/test_page3";
    private static final String PAGE0_IMAGE0_PATH = PAGE0 + "/jcr:content/root/page0_image0";
    private static final String PAGE0_IMAGE1_PATH = PAGE0 + "/jcr:content/root/page0_image1";
    private static final String PAGE1_IMAGE0_PATH = PAGE1 + "/jcr:content/root/page1_image0";
    private static final String PAGE2_IMAGE0_PATH = PAGE2 + "/jcr:content/root/page2_image0";
    private static final String PAGE3_IMAGE0_PATH = PAGE3 + "/jcr:content/root/page3_image0";

    @BeforeEach
    @Override
    protected void setUp() {
        selector = AdaptiveImageServlet.CORE_DEFAULT_SELECTOR;
        resourceType = ImageImpl.RESOURCE_TYPE;
        testBase = TEST_BASE;
        internalSetUp(TEST_BASE);
    }

    @Test
    void testImageWithLazyThreshold() {
        testImageWithLazyThreshold(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testGetDataLayerJson() throws Exception {
        testGetDataLayerJson(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImage() {
        testDMImage(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageOnAuthor() {
        testDMImageOnAuthor(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageOneSmartSize() {
        testDMImageOneSmartSize(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageTwoSmartSizes() {
        testDMImageTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithImagePreset() {
        testDMImageTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithImagePresetOneSmartSize() {
        testDMImageWithImagePresetOneSmartSize(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithImagePresetTwoSmartSizes() {
        testDMImageWithImagePresetTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithImageModifiers() {
        testDMImageWithImageModifiers(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithImagePresetAndImageModifiers() {
        testDMImageWithImagePresetAndImageModifiers(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithSmartCropRendition() {
        testDMImageTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithSmartCropRenditionOneSmartSize() {
        testDMImageWithSmartCropRenditionOneSmartSize(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithSmartCropRenditionTwoSmartSizes() {
        testDMImageWithSmartCropRenditionTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithSmartCropRenditionAndImageModifiers() {
        testDMImageWithSmartCropRenditionAndImageModifiers(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithAutoSmartCrop() {
        testDMImageWithAutoSmartCrop(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithAutoSmartCropOneSmartSize() {
        testDMImageWithAutoSmartCropOneSmartSize(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithAutoSmartCropTwoSmartSizes() {
        testDMImageWithAutoSmartCropTwoSmartSizes(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    void testDMImageWithAutoSmartCropAndImageModifiers() {
        testDMImageWithAutoSmartCropAndImageModifiers(ImageImpl.RESOURCE_TYPE);
    }

    @Test
    @SuppressWarnings("deprecation")
    @Override
    protected void testSimpleDecorativeImage() {
        context.contentPolicyMapping(resourceType,
                "uuidDisabled", true);
        String escapedResourcePath = AbstractImageTest.IMAGE4_PATH.replace("jcr:content", "_jcr_content");
        com.adobe.cq.wcm.core.components.models.Image image = getImageUnderTest(AbstractImageTest.IMAGE4_PATH);
        assertEquals(null, image.getAlt(), "Did not expect a value for the alt attribute, since the image is marked as decorative.");
        assertEquals("Adobe Systems Logo and Wordmark", image.getTitle());
        assertTrue(image.displayPopupTitle());
        assertEquals(null, image.getLink(), "Did not expect a link for this image, since it's marked as decorative.");
        assertEquals("850", image.getWidth());
        assertEquals("450", image.getHeight());
        assertNull(image.getImageLink(), "Expected null link");
        assertEquals(CONTEXT_PATH + escapedResourcePath + "." + selector + ".png/1494867377756/" + ASSET_NAME + ".png", image.getSrc());
        assertNull(image.getSrcset());
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, AbstractImageTest.IMAGE4_PATH));
    }

    @Test
    @SuppressWarnings("deprecation")
    @Override
    protected void testImageWithTwoOrMoreSmartSizes() {
        context.contentPolicyMapping(resourceType,
                "allowedRenditionWidths", new int[]{600, 700, 800, 2000, 2500});
        String escapedResourcePath = AbstractImageTest.IMAGE0_PATH.replace("jcr:content", "_jcr_content");
        Image image = getImageUnderTest(AbstractImageTest.IMAGE0_PATH);
        assertEquals("Adobe Systems Logo and Wordmark in PNG format", image.getAlt());
        assertEquals("Adobe Systems Logo and Wordmark", image.getTitle());
        assertEquals(IMAGE_FILE_REFERENCE, image.getFileReference());
        String expectedSrcset = "/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY + ".600.png/1490005239000/" + ASSET_NAME + ".png 600w," +
                "/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY + ".700.png/1490005239000/" + ASSET_NAME + ".png 700w," +
                "/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY + ".800.png/1490005239000/" + ASSET_NAME + ".png 800w," +
                "/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY + ".2000.png/1490005239000/" + ASSET_NAME + ".png 2000w," +
                "/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY + ".2500.png/1490005239000/" + ASSET_NAME + ".png 2500w";
        assertEquals(expectedSrcset, image.getSrcset());
        assertEquals("Adobe Systems Logo and Wordmark", image.getTitle());
        assertEquals(IMAGE_FILE_REFERENCE, image.getFileReference());
        String expectedJson = "{\"smartImages\":[\"/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY +
                ".600.png/1490005239000/" + ASSET_NAME + ".png\",\"/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY +
                ".700.png/1490005239000/" + ASSET_NAME + ".png\",\"/core/content/test/_jcr_content/root/image0" + "." + selector + "." + JPEG_QUALITY +
                ".800.png/1490005239000/" + ASSET_NAME + ".png\",\"/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY +
                ".2000.png/1490005239000/" + ASSET_NAME + ".png\", \"/core/content/test/_jcr_content/root/image0." + selector + "." + JPEG_QUALITY +
                ".2500.png/1490005239000/" + ASSET_NAME + ".png\"],\"smartSizes\":[600,700,800,2000,2500],\"lazyEnabled\":false}";
        compareJSON(expectedJson, image.getJson());
        assertTrue(image.displayPopupTitle());
        assertEquals(CONTEXT_PATH + "/content/test-image.html", image.getLink());
        assertValidLink(image.getImageLink(), "/content/test-image.html", context.request());
        assertEquals(CONTEXT_PATH + escapedResourcePath + "." + selector + ".png/1490005239000/" + ASSET_NAME + ".png", image.getSrc());
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, AbstractImageTest.IMAGE0_PATH));
    }

    @Test
    @SuppressWarnings("deprecation")
    @Override
    protected void testImageWithMap() {
        context.contentPolicyMapping(resourceType,
                "uuidDisabled", true);
        com.adobe.cq.wcm.core.components.models.Image image = getImageUnderTest(AbstractImageTest.IMAGE24_PATH);
        Object[][] expectedAreas = {
                {"circle", "256,256,256", "0.2000,0.3001,0.2000", "http://adobe.com", "", ""},
                {"rect", "256,171,1023,682", "0.1992,0.2005,0.7992,0.7995", "http://adobe.com", "", "altText"},
                {"poly", "917,344,1280,852,532,852", "0.7164,0.4033,1.0000,0.9988,0.4156,0.9988", "http://adobe.com", "_blank", ""}
        };
        List<ImageArea> areas = image.getAreas();
        int index = 0;
        while (areas.size() > index) {
            ImageArea area = areas.get(index);
            assertEquals(expectedAreas[index][0], area.getShape(), "The image area's shape is not as expected.");
            assertEquals(expectedAreas[index][1], area.getCoordinates(), "The image area's coordinates are not as expected.");
            assertEquals(expectedAreas[index][2], area.getRelativeCoordinates(), "The image area's relative coordinates are not as expected.");
            assertEquals(expectedAreas[index][3], area.getHref(), "The image area's href is not as expected.");
            assertEquals(expectedAreas[index][4], area.getTarget(), "The image area's target is not as expected.");
            assertEquals(expectedAreas[index][5], area.getAlt(), "The image area's alt text is not as expected.");
            assertValidLink(area.getLink(), (String)expectedAreas[index][3], StringUtils.trimToNull((String)expectedAreas[index][4]));
            index++;
        }
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, AbstractImageTest.IMAGE24_PATH));
    }

    @Test
    protected void testEmptyImageDelegatingToFeaturedImage() {
        Image image = getImageUnderTest(IMAGE50_PATH);
        assertEquals("/core/content/test/_jcr_content/root/image50.coreimg.png/1490005239000/adobe-systems-logo-and-wordmark.png", image.getSrc(), "getSrc()");
        assertEquals("Adobe Systems Logo and Wordmark in PNG format", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        assertEquals("image-cf7954fac5", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE50_PATH));
    }

    @Test
    protected void testInheritedFeaturedImage_altValueFromPageImage() {
        Image image = getImageUnderTest(IMAGE51_PATH);
        assertEquals("Adobe Systems Logo and Wordmark in PNG format", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE51_PATH));
    }

    @Test
    protected void testInheritedFeaturedImage_altValueFromImage() {
        Image image = getImageUnderTest(IMAGE52_PATH);
        assertEquals("image52 alt", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE52_PATH));
    }

    @Test
    protected void testInheritedFeaturedImage_altValueFromPageImage_decorative() {
        Image image = getImageUnderTest(IMAGE53_PATH);
        assertNull(image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE53_PATH));
    }

    @Test
    protected void testInheritedFeaturedImage_altValueFromImage_decorative() {
        Image image = getImageUnderTest(IMAGE54_PATH);
        assertNull(image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE54_PATH));
    }

    @Test
    protected void testNoInheritedFeaturedImage_altValueFromDAM() {
        Image image = getImageUnderTest(IMAGE55_PATH);
        assertEquals("transparent HD PNG", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/transparent_hd.png", image.getFileReference(), "getFileReference()");
        assertEquals("f6460529-b7b1-4b3a-8980-b3b3f0ee109c", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE55_PATH));
    }

    @Test
    protected void testNoInheritedFeaturedImage_altValueFromImage() {
        Image image = getImageUnderTest(IMAGE56_PATH);
        assertEquals("image52a alt", image.getAlt(), "getAlt()");
        assertNull(image.getFileReference(), "getFileReference()");
        assertNull(image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE56_PATH));
    }

    @Test
    protected void testNoInheritedFeaturedImage_altValueFromDAM_decorative() {
        Image image = getImageUnderTest(IMAGE57_PATH);
        assertNull(image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/transparent_hd.png", image.getFileReference(), "getFileReference()");
        assertEquals("f6460529-b7b1-4b3a-8980-b3b3f0ee109c", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE57_PATH));
    }

    @Test
    protected void testNoInheritedFeaturedImage_altValueFromImage_decorative() {
        Image image = getImageUnderTest(IMAGE58_PATH);
        assertNull(image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/transparent_hd.png", image.getFileReference(), "getFileReference()");
        assertEquals("f6460529-b7b1-4b3a-8980-b3b3f0ee109c", image.getUuid(), "getUuid()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, IMAGE58_PATH));
    }

    @Test
    protected void testEmptyImage_emptyFeaturedImage() {
        Image image = getImageUnderTest(PAGE0_IMAGE0_PATH);
        assertNull(image.getSrc(), "getSrc()");
        assertNull(image.getAlt(), "getAlt()");
        assertNull(image.getFileReference(), "getFileReference()");
        assertNull(image.getUuid(), "getUuid()");
        assertEquals("image-c7ca64a6e5", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, PAGE0_IMAGE0_PATH));
    }

    @Test
    protected void testEmptyImage_emptyFeaturedImage_inherit() {
        Image image = getImageUnderTest(PAGE0_IMAGE1_PATH);
        assertNull(image.getSrc(), "getSrc()");
        assertNull(image.getAlt(), "getAlt()");
        assertNull(image.getFileReference(), "getFileReference()");
        assertNull(image.getUuid(), "getUuid()");
        assertEquals("image-61631780d5", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, PAGE0_IMAGE1_PATH));
    }

    @Test
    protected void testInheritedPageImage_pageImageAltValueFromDAM() {
        Image image = getImageUnderTest(PAGE1_IMAGE0_PATH);
        assertEquals("/core/content/test_page1/_jcr_content/root/page1_image0.coreimg.png/1490005239000/adobe-systems-logo-and-wordmark.png", image.getSrc(), "getSrc()");
        assertEquals("Adobe Systems Logo and Wordmark in PNG format", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        assertEquals("image-6401b77a35", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, PAGE1_IMAGE0_PATH));
    }

    @Test
    protected void testInheritedPageImage_pageImageAltValueFromResource() {
        Image image = getImageUnderTest(PAGE2_IMAGE0_PATH);
        assertEquals("/core/content/test_page2/_jcr_content/root/page2_image0.coreimg.png/1490005239000/adobe-systems-logo-and-wordmark.png", image.getSrc(), "getSrc()");
        assertEquals("featured image alt", image.getAlt(), "getAlt()");
        assertEquals("/content/dam/core/images/Adobe_Systems_logo_and_wordmark.png", image.getFileReference(), "getFileReference()");
        assertEquals("60a1a56e-f3f4-4021-a7bf-ac7a51f0ffe5", image.getUuid(), "getUuid()");
        assertEquals("image-310f56f715", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, PAGE2_IMAGE0_PATH));
    }

    @Test
    protected void testInheritedPageImage_pageImageAltValueFromResource_withFileResource() {
        Image image = getImageUnderTest(PAGE3_IMAGE0_PATH);
        assertEquals("/core/content/test_page3/_jcr_content/root/page3_image0.coreimg.png", image.getSrc(), "getSrc()");
        assertEquals("featured image alt", image.getAlt(), "getAlt()");
        assertNull(image.getFileReference(), "getFileReference()");
        assertNull(image.getUuid(), "getUuid()");
        assertEquals("image-96253254e2", image.getId(), "getId()");
        Utils.testJSONExport(image, Utils.getTestExporterJSONPath(testBase, PAGE3_IMAGE0_PATH));
    }

}
