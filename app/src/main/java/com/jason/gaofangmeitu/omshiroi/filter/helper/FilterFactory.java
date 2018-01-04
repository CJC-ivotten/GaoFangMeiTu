package com.jason.gaofangmeitu.omshiroi.filter.helper;

import android.content.Context;

import com.jason.gaofangmeitu.omshiroi.filter.base.AbsFilter;
import com.jason.gaofangmeitu.omshiroi.filter.base.PassThroughFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.SphereReflector;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterA;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterFUB;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterFUC;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterFUD;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterFUE;
import com.jason.gaofangmeitu.omshiroi.filter.effect.beautify.BeautifyFilterFUF;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsAmaroFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsAntiqueFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsBlackCatFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsBrooklynFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsCalmFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsCoolFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsCrayonFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsEarlyBirdFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsEmeraldFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsEvergreenFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsFairyTaleFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsFreudFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsHealthyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsHefeFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsHudsonFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsKevinFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsLatteFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsLomoFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsN1977Filter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.insta.InsNashvilleFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsNostalgiaFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsPixarFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsRiseFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsRomanceFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSakuraFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSierraFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSketchFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSkinWhitenFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSunriseFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSunsetFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSutroFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsSweetsFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsTenderFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsToasterFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsValenciaFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsWaldenFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsWarmFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsWhiteCatFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.instb.InsXproIIFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.BlackWhiteFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.BrightnessFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.FillLightFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.GreenHouseFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.MoonLightFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.MultiplyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.MxFaceBeautyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.MxLomoFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.MxProFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.PastTimeFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.PrintingFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.ReminiscenceFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.ShiftColorFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.SunnyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.ToyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.mx.VignetteFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.AscIIArtFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.BasicDeformFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.BlueorangeFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.ChromaticAberrationFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.ContrastFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.CrackedFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.CrosshatchFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.EMInterferenceFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.EdgeDetectionFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.FastBlurFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.LegofiedFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.LichtensteinEsqueFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.MappingFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.MoneyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.NoiseWarpFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.PixelizeFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.PolygonizationFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.RandomBlurFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.RefractionFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.TileMosaicFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.shadertoy.TrianglesMosaicFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.BeachFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.BrannanFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.CleanFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.CoralFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.CrispFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.FUOriginFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.FreshFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.GrassFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.InkwellFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.LolitaFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.NatureFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.PinkFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.RococoFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.RosyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.SunsetFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.SweetyFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.UrbanFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.ValenciaFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.VintageFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.VividFilter;
import com.jason.gaofangmeitu.omshiroi.filter.effect.xiuxiuxiu.WaldenFilter;
import com.jason.gaofangmeitu.omshiroi.filter.ext.BlurredFrameEffect;
import com.jason.gaofangmeitu.omshiroi.filter.ext.BraSizeTestLeftFilter;
import com.jason.gaofangmeitu.omshiroi.filter.ext.BraSizeTestRightFilter;
import com.jason.gaofangmeitu.omshiroi.filter.ext.ScalingFilter;
import com.jason.gaofangmeitu.omshiroi.filter.imgproc.CustomizedBoxBlurFilter;
import com.jason.gaofangmeitu.omshiroi.filter.imgproc.GaussianBlurFilter;
import com.jason.gaofangmeitu.omshiroi.filter.imgproc.GrayScaleShaderFilter;
import com.jason.gaofangmeitu.omshiroi.filter.imgproc.InvertColorFilter;


/**
 * Created by Ads on 2017/2/13.
 */

public class FilterFactory {

    public static AbsFilter createFilter(FilterType filterType, Context context){
        switch (filterType){
            //Image Processing
            case GRAY_SCALE:
                return new GrayScaleShaderFilter(context);
            case INVERT_COLOR:
                return new InvertColorFilter(context);

            //Effects
            case SPHERE_REFLECTOR:
                return new SphereReflector(context);
            case FILL_LIGHT_FILTER:
                return new FillLightFilter(context);
            case GREEN_HOUSE_FILTER:
                return new GreenHouseFilter(context);
            case BLACK_WHITE_FILTER:
                return new BlackWhiteFilter(context);
            case PAST_TIME_FILTER:
                return new PastTimeFilter(context);
            case MOON_LIGHT_FILTER:
                return new MoonLightFilter(context);
            case PRINTING_FILTER:
                return new PrintingFilter(context);
            case TOY_FILTER:
                return new ToyFilter(context);
            case BRIGHTNESS_FILTER:
                return new BrightnessFilter(context);
            case VIGNETTE_FILTER:
                return new VignetteFilter(context);
            case MULTIPLY_FILTER:
                return new MultiplyFilter(context);
            case REMINISCENCE_FILTER:
                return new ReminiscenceFilter(context);
            case SUNNY_FILTER:
                return new SunnyFilter(context);
            case MX_LOMO_FILTER:
                return new MxLomoFilter(context);
            case SHIFT_COLOR_FILTER:
                return new ShiftColorFilter(context);
            case MX_FACE_BEAUTY_FILTER:
                return new MxFaceBeautyFilter(context);
            case MX_PRO_FILTER:
                return new MxProFilter(context);

            //Extended
            case BRA_SIZE_TEST_LEFT:
                return new BraSizeTestLeftFilter(context);
            case BRA_SIZE_TEST_RIGHT:
                return new BraSizeTestRightFilter(context);

            //ShaderToy : 20
            case EDGE_DETECTION_FILTER:
                return new EdgeDetectionFilter(context);
            case PIXELIZE_FILTER:
                return new PixelizeFilter(context);
            case EM_INTERFERENCE_FILTER:
                return new EMInterferenceFilter(context);
            case TRIANGLES_MOSAIC_FILTER:
                return new TrianglesMosaicFilter(context);
            case LEGOFIED_FILTER:
                return new LegofiedFilter(context);
            case TILE_MOSAIC_FILTER:
                return new TileMosaicFilter(context);
            case BLUEORANGE_FILTER:
                return new BlueorangeFilter(context);
            case CHROMATIC_ABERRATION_FILTER:
                return new ChromaticAberrationFilter(context);
            case BASICDEFORM_FILTER:
                return new BasicDeformFilter(context);
            case CONTRAST_FILTER:
                return new ContrastFilter(context);
            case NOISE_WARP_FILTER:
                return new NoiseWarpFilter(context);
            case REFRACTION_FILTER:
                return new RefractionFilter(context);
            case MAPPING_FILTER:
                return new MappingFilter(context);
            case CROSSHATCH_FILTER:
                return new CrosshatchFilter(context);
            case LICHTENSTEINESQUE_FILTER:
                return new LichtensteinEsqueFilter(context);
            case ASCII_ART_FILTER:
                return new AscIIArtFilter(context);
            case MONEY_FILTER:
                return new MoneyFilter(context);
            case CRACKED_FILTER:
                return new CrackedFilter(context);
            case POLYGONIZATION_FILTER:
                return new PolygonizationFilter(context);
            case FAST_BLUR_FILTER:
                return new FastBlurFilter(context);

            //XiuXiuXiu
            case NATURE:
                return new NatureFilter(context);
            case CLEAN:
                return new CleanFilter(context);
            case VIVID:
                return new VividFilter(context);
            case FRESH:
                return new FreshFilter(context);
            case SWEETY:
                return new SweetyFilter(context);
            case ROSY:
                return new RosyFilter(context);
            case LOLITA:
                return new LolitaFilter(context);
            case SUNSET:
                return new SunsetFilter(context);
            case GRASS:
                return new GrassFilter(context);
            case CORAL:
                return new CoralFilter(context);
            case PINK:
                return new PinkFilter(context);
            case URBAN:
                return new UrbanFilter(context);
            case CRISP:
                return new CrispFilter(context);
            case VALENCIA:
                return new ValenciaFilter(context);
            case BEACH:
                return new BeachFilter(context);
            case VINTAGE:
                return new VintageFilter(context);
            case ROCOCO:
                return new RococoFilter(context);
            case WALDEN:
                return new WaldenFilter(context);
            case BRANNAN:
                return new BrannanFilter(context);
            case INKWELL:
                return new InkwellFilter(context);
            case FUORIGIN:
                return new FUOriginFilter(context);

            //Inst
            case AMARO:
                return new InsAmaroFilter(context);
            case ANTIQUE:
                return new InsAntiqueFilter(context);
            case BLACK_CAT:
                return new InsBlackCatFilter(context);
            case BROOKLYN:
                return new InsBrooklynFilter(context);
            case CALM:
                return new InsCalmFilter(context);
            case COOL:
                return new InsCoolFilter(context);
            case CRAYON:
                return new InsCrayonFilter(context);
            case EARLY_BIRD:
                return new InsEarlyBirdFilter(context);
            case EMERALD:
                return new InsEmeraldFilter(context);
            case EVERGREEN:
                return new InsEvergreenFilter(context);
            case FAIRY_TALE:
                return new InsFairyTaleFilter(context);
            case FREUD:
                return new InsFreudFilter(context);
            case HEALTHY:
                return new InsHealthyFilter(context);
            case HEFE:
                return new InsHefeFilter(context);
            case HUDSON:
                return new InsHudsonFilter(context);
            case KEVIN:
                return new InsKevinFilter(context);
            case LATTE:
                return new InsLatteFilter(context);
            case LOMO:
                return new InsLomoFilter(context);
            case N1977:
                return new InsN1977Filter(context);
            case NASHVILLE:
                return new InsNashvilleFilter(context);
            case NOSTALGIA:
                return new InsNostalgiaFilter(context);
            case PIXAR:
                return new InsPixarFilter(context);
            case RISE:
                return new InsRiseFilter(context);
            case ROMANCE:
                return new InsRomanceFilter(context);
            case SAKURA:
                return new InsSakuraFilter(context);
            case SIERRA:
                return new InsSierraFilter(context);
            case SKETCH:
                return new InsSketchFilter(context);
            case SKIN_WHITEN:
                return new InsSkinWhitenFilter(context);
            case SUNRISE:
                return new InsSunriseFilter(context);
            case SUNSET2:
                return new InsSunsetFilter(context);
            case SUTRO:
                return new InsSutroFilter(context);
            case SWEETS:
                return new InsSweetsFilter(context);
            case TENDER:
                return new InsTenderFilter(context);
            case TOASTER:
                return new InsToasterFilter(context);
            case VALENCIA2:
                return new InsValenciaFilter(context);
            case WALDEN2:
                return new InsWaldenFilter(context);
            case WARM:
                return new InsWarmFilter(context);
            case WHITE_CAT:
                return new InsWhiteCatFilter(context);
            case XPROII:
                return new InsXproIIFilter(context);

            //Beautify
            case BEAUTIFY_A:
                return new BeautifyFilterA(context);
            case BEAUTIFY_FU_B:
                return new BeautifyFilterFUB(context);
            case BEAUTIFY_FU_C:
                return new BeautifyFilterFUC(context);
            case BEAUTIFY_FU_D:
                return new BeautifyFilterFUD(context);
            case BEAUTIFY_FU_E:
                return new BeautifyFilterFUE(context);
            case BEAUTIFY_FU_F:
                return new BeautifyFilterFUF(context);
            default:
                return new PassThroughFilter(context);
        }
    }

    public static AbsFilter createFilterExt(FilterTypeExt filterTypeExt, Context context){
        switch (filterTypeExt){
            //Effects
            case SCALING:
                return new ScalingFilter(context);
            case GAUSSIAN_BLUR:
                return new GaussianBlurFilter(context);
            case BLURRED_FRAME:
                return new BlurredFrameEffect(context);
            case BOX_BLUR:
                return new CustomizedBoxBlurFilter(4);
            case FAST_BLUR:
                return new FastBlurFilter(context);
            case RANDOM_BLUR:
                return new RandomBlurFilter(context);
            default:
                return null;
        }
    }
}
