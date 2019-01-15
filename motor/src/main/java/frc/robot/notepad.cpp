#define _GLIBCXX_USE_CXX11_ABI 0
#ifndef MAP_H
#define MAP_H
#include <SDL2/SDL.h>
#include <BATTLE_SCENE.h>
#include <mainmap.h>
#include <Change_scene.h>
#include <iostream>
#include "definition.h"
#include "music.h"
#include <TUTORIAL.h>
#include <MULTI_PLAYER.h>
#include<BATTLE_SETTING.h>
#include<BATTLE_SCENE_MULTI.h>
using namespace std;
#include<string>

const string music_name[MUSIC]={
        "music/maple.mp3",
        "music/village.wav",
        "music/Warfare.wav",
        "music/sao.wav",
        "music/battle.wav",
        "music/bar.wav",
        "music/teacher3.wav",
        "music/sorrow.wav",
        "music/mikasa.mp3"
};
const string sound_n[SOUND1]={
        "music/teacher3.wav",
};
enum music_enum{
    maple=0,
    village=1,
    battle1=2,
    battle2=3,
    battle3=4,
    bar=5,
    teacher1=6,
    sorrow=7,
    mikasa=8,

};
#define MUSIC 9
        music bgm[MUSIC];
for(int i=0;i<MUSIC;i++)bgm[i].loadmusic(music_name[i]);

void map_but(SDL_Event &a,int &mode,LTexture,LButton,int l_x,int l_y，int k);

void mainmap::map_but(SDL_Event &a,int &mode){
    if(clean){
        handleEvent(&a);
        setPosition(l_x,l_y);
        setdim(mWidth,mHeight);
        if(get_sprite()==BUTTON_SPRITE_MOUSE_OVER_MOTION){
            render(l_x,l_y);
        }
        else if(get_sprite()==BUTTON_SPRITE_MOUSE_DOWN){
            sound[0].playsound();
            mode=k;
            return;
        }
        else render(l_x,l_y,0.9,0.9);
    }else {setColor(100,100,100);render(l_x,l_y);}
return;
}
:


void Change_scene:: scroll(bool x,bool y,bool inf){

    if(x){
        --offsetx;
        if(offsetx<=-getWidth()){
            if(inf){offsetx=0;}
            else ++offsetx;
        }

        render(offsetx,0);
        render(offsetx+getWidth(),0);
    }
    if(y){
        --offsety;
        if(offsety<=SCREEN_HEIGHT-getHeight()){
            if(inf){offsety=0;}
            else {++offsety;}
        }
        render(0,offsety);

    }

}
class LButton
{
    public:
        LButton();
        virtual ~LButton();
    void setPosition( int x, int y )e
        {
            mPosition.x = x;
            mPosition.y = y;
        }
        int get_x(){return mPosition.x;}
        int get_y(){return mPosition.y;}




        int getwidth(){return BUTTON_WIDTH;}
		int getheight(){return BUTTON_HEIGHT;}
		void setdim(int a,int b){BUTTON_WIDTH=a;BUTTON_HEIGHT=b;}
        void setpos(int a){pos=a;}
        int get_pos(){return pos;}
        LButtonSprite get_sprite(){return mCurrentSprite;}
        friend class loop;
    private:
        //Top left position
		SDL_Point mPosition;
        int pos;
		int BUTTON_WIDTH;
		int BUTTON_HEIGHT;
		//Currently used global sprite
		LButtonSprite mCurrentSprite;

    
BATTLE_SCENE::BATTLE_SCENE(int category)
{
 initialize(category);
}

BATTLE_SCENE **DUCK=new BATTLE_SCENE* [12];

m.Map_mode(e,DUCK,quit);

void Map_mode(SDL_Event &e,BATTLE_SCENE **b,bool &quit);

if(mode!=1){
    b[now]=new BATTLE_SCENE(now%3);
    bgm[village].stopmusic();
    SDL_Delay(200);break;
}

void Map::Map_ini(){
    load();//load all map pics
    for(int i=0;i<icon_n;i++){
        icon[i].set_value(iconx[i],icony[i],iconm[i]);
        icon[i].mapmusic();
    }//set icon's position
    for(int i=0;i<menu_num;i++){
        menu[i].set_value(menux[i],menuy[i],menum[i]);
        menu[i].mapmusic();
    }//set menu's position
    for(int i=0;i<MUSIC;i++)bgm[i].loadmusic(music_name[i]);
    tutorial_guide=new TUTORIAL;


}

void Map::load(){//load LTexture&Change
    for(int k=0;k<menu_num;k++)menu[k].loadFromFile(menu_image[k]);
    for(int k=0;k<scene_num;k++)scene[k].loadFromFile(scene_image[k]);
    for(int k=0;k<map_num;k++)_map[k].loadFromFile(map_image[k]);
    for(int k=0;k<about_num;k++)about[k].loadFromFile(about_image[k]);
    for(int k=0;k<icon_n;k++)icon[k].loadFromFile(icon_image[k]);
}

Map::Map()
{
    MULTI_PLAYER *player=new MULTI_PLAYER;
    Map_ini();//ctor
}

music::~music()
{
	Mix_FreeChunk( Chunk );
	Mix_FreeMusic( Music );
	Chunk = NULL;
	Music = NULL;
    //dtor
}

men_with_arms& men_with_arms::operator+(const int &a){
    this->health=this->health+a;
    return *this;
}
int men_with_arms::operator-(men_with_arms *foe){
    *foe=*foe+(-this->Random(this->strength));
    if(foe->health<=0){
        if((this->arms==melee)or(this->arms==air_force)){
            int mem=foe->pos;

            return mem;
        }
        else if(this->arms==archer){
            int mem=-foe->pos-1;

            return mem;
        }
    }
    else return this->pos;
}