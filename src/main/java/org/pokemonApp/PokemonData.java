package org.pokemonApp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonData {
    public int id;
    public String name;
    @SerializedName("base_experience")
    public int baseExperience;
    public int height;
    @SerializedName("is_default")
    public boolean isDefault;
    public int order;
    public int weight;
    public List<AbilitySlot> abilities;
    public List<PokemonForm> forms;
    @SerializedName("game_indices")
    public List<GameIndex> gameIndices;
    @SerializedName("held_items")
    public List<HeldItem> heldItems;
    @SerializedName("location_area_encounters")
    public String locationAreaEncounters;
    public List<MoveSlot> moves;
    public PokemonSpecies species;
    public Sprites sprites;
    public Cries cries;
    public List<Stat> stats;
    public List<TypeSlot> types;
    @SerializedName("past_types")
    public List<PastType> pastTypes;

    public static class AbilitySlot {
        @SerializedName("is_hidden")
        public boolean isHidden;
        public int slot;
        public Ability ability;
    }

    public static class Ability {
        public String name;
        public String url;
    }

    public static class PokemonForm {
        public String name;
        public String url;
    }

    public static class GameIndex {
        @SerializedName("game_index")
        public int gameIndex;
        public Version version;
    }

    public static class Version {
        public String name;
        public String url;
    }

    public static class HeldItem {
        public Item item;
        @SerializedName("version_details")
        public List<VersionDetail> versionDetails;
    }

    public static class Item {
        public String name;
        public String url;
    }

    public static class VersionDetail {
        public int rarity;
        public Version version;
    }

    public static class MoveSlot {
        public Move move;
        @SerializedName("version_group_details")
        public List<VersionGroupDetail> versionGroupDetails;
    }

    public static class Move {
        public String name;
        public String url;
    }

    public static class VersionGroupDetail {
        @SerializedName("level_learned_at")
        public int levelLearnedAt;
        @SerializedName("version_group")
        public VersionGroup versionGroup;
        @SerializedName("move_learn_method")
        public MoveLearnMethod moveLearnMethod;
    }

    public static class VersionGroup {
        public String name;
        public String url;
    }

    public static class MoveLearnMethod {
        public String name;
        public String url;
    }

    public static class PokemonSpecies {
        public String name;
        public String url;
    }

    public static class Sprites {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
        public Other other;
        public Versions versions;
    }

    public static class Other {
        @SerializedName("dream_world")
        public DreamWorld dreamWorld;
        public Home home;
        @SerializedName("official-artwork")
        public OfficialArtwork officialArtwork;
        public Showdown showdown;
    }

    public static class DreamWorld {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
    }

    public static class Home {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class OfficialArtwork {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class Showdown {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class Versions {
        @SerializedName("generation-i")
        public GenerationI generationI;
        @SerializedName("generation-ii")
        public GenerationII generationII;
        @SerializedName("generation-iii")
        public GenerationIII generationIII;
        @SerializedName("generation-iv")
        public GenerationIV generationIV;
        @SerializedName("generation-v")
        public GenerationV generationV;
        @SerializedName("generation-vi")
        public GenerationVI generationVI;
        @SerializedName("generation-vii")
        public GenerationVII generationVII;
        @SerializedName("generation-viii")
        public GenerationVIII generationVIII;
    }

    public static class GenerationI {
        @SerializedName("red-blue")
        public RedBlue redBlue;
        public Yellow yellow;
    }

    public static class RedBlue {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_gray")
        public String backGray;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_gray")
        public String frontGray;
    }

    public static class Yellow {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_gray")
        public String backGray;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_gray")
        public String frontGray;
    }

    public static class GenerationII {
        public Crystal crystal;
        public Gold gold;
        public Silver silver;
    }

    public static class Crystal {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class Gold {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class Silver {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class GenerationIII {
        public Emerald emerald;
        @SerializedName("firered-leafgreen")
        public FireredLeafgreen fireredLeafgreen;
        @SerializedName("ruby-sapphire")
        public RubySapphire rubySapphire;
    }

    public static class Emerald {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class FireredLeafgreen {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class RubySapphire {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_shiny")
        public String frontShiny;
    }

    public static class GenerationIV {
        @SerializedName("diamond-pearl")
        public DiamondPearl diamondPearl;
        @SerializedName("heartgold-soulsilver")
        public HeartgoldSoulsilver heartgoldSoulsilver;
        public Platinum platinum;
    }

    public static class DiamondPearl {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class HeartgoldSoulsilver {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class Platinum {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class GenerationV {
        @SerializedName("black-white")
        public BlackWhite blackWhite;
    }

    public static class BlackWhite {
        public Animated animated;
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class Animated {
        @SerializedName("back_default")
        public String backDefault;
        @SerializedName("back_female")
        public String backFemale;
        @SerializedName("back_shiny")
        public String backShiny;
        @SerializedName("back_shiny_female")
        public String backShinyFemale;
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class GenerationVI {
        @SerializedName("omegaruby-alphasapphire")
        public OmegarubyAlphasapphire omegarubyAlphasapphire;
        @SerializedName("x-y")
        public XY xy;
    }

    public static class OmegarubyAlphasapphire {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class XY {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class GenerationVII {
        public Icons icons;
        @SerializedName("ultra-sun-ultra-moon")
        public UltraSunUltraMoon ultraSunUltraMoon;
    }

    public static class Icons {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
    }

    public static class UltraSunUltraMoon {
        @SerializedName("front_default")
        public String frontDefault;
        @SerializedName("front_female")
        public String frontFemale;
        @SerializedName("front_shiny")
        public String frontShiny;
        @SerializedName("front_shiny_female")
        public String frontShinyFemale;
    }

    public static class GenerationVIII {
        public Icons icons;
    }

    public static class Cries {
        public String latest;
        public String legacy;
    }

    public static class Stat {
        @SerializedName("base_stat")
        public int baseStat;
        public int effort;
        public StatDetail stat;
    }

    public static class StatDetail {
        public String name;
        public String url;
    }

    public static class TypeSlot {
        public int slot;
        public Type type;
    }

    public static class Type {
        public String name;
        public String url;
    }

    public static class PastType {
        public Generation generation;
        public List<TypeSlot> types;
    }

    public static class Generation {
        public String name;
        public String url;
    }
}