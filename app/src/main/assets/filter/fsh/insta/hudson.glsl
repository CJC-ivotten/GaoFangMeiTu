 precision mediump float;

 varying mediump vec2 vTextureCoord;
 
 uniform sampler2D sTexture;
 uniform sampler2D sTexture2; //blowout;
 uniform sampler2D sTexture3; //overlay;
 uniform sampler2D sTexture4; //map
 
 uniform float strength;
 
 void main()
 {
     vec4 originColor = texture2D(sTexture, vTextureCoord);
     
     vec4 texel = texture2D(sTexture, vTextureCoord);
     
     vec3 bbTexel = texture2D(sTexture2, vTextureCoord).rgb;
     
     texel.r = texture2D(sTexture3, vec2(bbTexel.r, texel.r)).r;
     texel.g = texture2D(sTexture3, vec2(bbTexel.g, texel.g)).g;
     texel.b = texture2D(sTexture3, vec2(bbTexel.b, texel.b)).b;
     
     vec4 mapped;
     mapped.r = texture2D(sTexture4, vec2(texel.r, .16666)).r;
     mapped.g = texture2D(sTexture4, vec2(texel.g, .5)).g;
     mapped.b = texture2D(sTexture4, vec2(texel.b, .83333)).b;
     mapped.a = 1.0;
     
     mapped.rgb = mix(originColor.rgb, mapped.rgb, strength);

     gl_FragColor = mapped;
 }