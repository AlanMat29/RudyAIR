import { StatutAvion } from './statut-avion';

export class Avion {
  private _id: number | undefined;
  private _ref: string | undefined;
  private _siege: Siege | undefined;
  private _statutAvion: StatutAvion | undefined;
  private _vol: Vol | undefined;

  constructor(
    id?: number,
    ref?: string,
    siege?: Siege,
    statutAvion?: StatutAvion,
    vol?: Vol
  ) {
    this._id = id;
    this._ref = ref;
    this._siege = siege;
    this._statutAvion = statutAvion;
    this._vol = vol;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter ref
   * @return {string }
   */
  public get ref(): string | undefined {
    return this._ref;
  }

  /**
   * Getter siege
   * @return {Siege }
   */
  public get siege(): Siege | undefined {
    return this._siege;
  }

  /**
   * Getter statutAvion
   * @return {StatutAvion }
   */
  public get statutAvion(): StatutAvion | undefined {
    return this._statutAvion;
  }

  /**
   * Getter vol
   * @return {Vol }
   */
  public get vol(): Vol | undefined {
    return this._vol;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter ref
   * @param {string } value
   */
  public set ref(value: string | undefined) {
    this._ref = value;
  }

  /**
   * Setter siege
   * @param {Siege } value
   */
  public set siege(value: Siege | undefined) {
    this._siege = value;
  }

  /**
   * Setter statutAvion
   * @param {StatutAvion } value
   */
  public set statutAvion(value: StatutAvion | undefined) {
    this._statutAvion = value;
  }

  /**
   * Setter vol
   * @param {Vol } value
   */
  public set vol(value: Vol | undefined) {
    this._vol = value;
  }
}
